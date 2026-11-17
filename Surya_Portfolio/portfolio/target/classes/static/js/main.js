(function () {
  'use strict';

  /* ---------- Animated particle network background ---------- */
  var canvas = document.getElementById('bg');
  var ctx = canvas.getContext('2d');
  var pts = [], W, H, mouse = { x: -999, y: -999 };

  function resize() {
    W = canvas.width = window.innerWidth;
    H = canvas.height = window.innerHeight;
    var n = Math.min(90, Math.floor(W * H / 16000));
    pts = [];
    for (var i = 0; i < n; i++) {
      pts.push({ x: Math.random() * W, y: Math.random() * H,
                 vx: (Math.random() - .5) * .5, vy: (Math.random() - .5) * .5 });
    }
  }
  window.addEventListener('resize', resize);
  window.addEventListener('mousemove', function (e) { mouse.x = e.clientX; mouse.y = e.clientY; });

  function frame() {
    ctx.clearRect(0, 0, W, H);
    for (var i = 0; i < pts.length; i++) {
      var p = pts[i];
      p.x += p.vx; p.y += p.vy;
      if (p.x < 0 || p.x > W) p.vx *= -1;
      if (p.y < 0 || p.y > H) p.vy *= -1;
      ctx.beginPath();
      ctx.arc(p.x, p.y, 1.8, 0, Math.PI * 2);
      ctx.fillStyle = 'rgba(94,200,255,.8)';
      ctx.fill();
      for (var j = i + 1; j < pts.length; j++) {
        var q = pts[j], dx = p.x - q.x, dy = p.y - q.y, d = Math.sqrt(dx * dx + dy * dy);
        if (d < 130) {
          ctx.strokeStyle = 'rgba(94,200,255,' + (0.18 * (1 - d / 130)) + ')';
          ctx.lineWidth = 1;
          ctx.beginPath(); ctx.moveTo(p.x, p.y); ctx.lineTo(q.x, q.y); ctx.stroke();
        }
      }
      var mx = p.x - mouse.x, my = p.y - mouse.y, md = Math.sqrt(mx * mx + my * my);
      if (md < 160) {
        ctx.strokeStyle = 'rgba(139,123,255,' + (0.35 * (1 - md / 160)) + ')';
        ctx.beginPath(); ctx.moveTo(p.x, p.y); ctx.lineTo(mouse.x, mouse.y); ctx.stroke();
      }
    }
    requestAnimationFrame(frame);
  }
  resize(); frame();

  /* ---------- Typing effect ---------- */
  var typed = document.getElementById('typed');
  if (typed) {
    var roles = typed.getAttribute('data-roles').split('|');
    var ri = 0, ci = 0, del = false;
    (function type() {
      var word = roles[ri];
      typed.textContent = word.substring(0, ci);
      if (!del && ci < word.length) { ci++; setTimeout(type, 85); }
      else if (!del) { del = true; setTimeout(type, 1400); }
      else if (ci > 0) { ci--; setTimeout(type, 40); }
      else { del = false; ri = (ri + 1) % roles.length; setTimeout(type, 300); }
    })();
  }

  /* ---------- Reveal on scroll + counters ---------- */
  function countUp(el) {
    var target = parseInt(el.getAttribute('data-target'), 10) || 0;
    var prefix = el.getAttribute('data-prefix') || '';
    var suffix = el.getAttribute('data-suffix') || '';
    var cur = 0, step = Math.max(1, Math.ceil(target / 40));
    var t = setInterval(function () {
      cur += step;
      if (cur >= target) { cur = target; clearInterval(t); }
      el.textContent = prefix + cur + suffix;
    }, 40);
  }
  var io = new IntersectionObserver(function (entries) {
    entries.forEach(function (e) {
      if (e.isIntersecting) {
        e.target.classList.add('visible');
        e.target.querySelectorAll('[data-target]').forEach(countUp);
        io.unobserve(e.target);
      }
    });
  }, { threshold: .15 });
  document.querySelectorAll('.reveal').forEach(function (el) { io.observe(el); });

  /* ---------- 3D tilt on cards ---------- */
  document.querySelectorAll('.tilt').forEach(function (card) {
    card.addEventListener('mousemove', function (e) {
      var r = card.getBoundingClientRect();
      var x = (e.clientX - r.left) / r.width - .5;
      var y = (e.clientY - r.top) / r.height - .5;
      card.style.transform = 'perspective(700px) rotateY(' + (x * 12) + 'deg) rotateX(' + (-y * 12) + 'deg) translateY(-4px)';
    });
    card.addEventListener('mouseleave', function () { card.style.transform = ''; });
  });

  /* ---------- Mobile menu ---------- */
  var burger = document.getElementById('burger'), menu = document.getElementById('menu');
  burger.addEventListener('click', function () { menu.classList.toggle('open'); });
  menu.querySelectorAll('a').forEach(function (a) {
    a.addEventListener('click', function () { menu.classList.remove('open'); });
  });

  /* ---------- Hero video: hide if no video file has been added ---------- */
  var v = document.getElementById('heroVideo');
  if (v) {
    var src = v.querySelector('source');
    src.addEventListener('error', function () { v.style.display = 'none'; });
  }

  document.getElementById('year').textContent = new Date().getFullYear();
})();
