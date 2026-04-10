/* ═══════════════════════════════════════════════════════════════
   Digital Diary — app.js
   Central JS file: API calls, auth helpers, shared utilities
═══════════════════════════════════════════════════════════════ */

// ─── Configuration ───────────────────────────────────────────────────────────
const API_BASE = 'http://localhost:8080/api';

// ─── Auth Helpers ────────────────────────────────────────────────────────────

/** Save logged-in user to localStorage */
function setUser(user) {
  localStorage.setItem('diary_user', JSON.stringify(user));
}

/** Get logged-in user from localStorage */
function getUser() {
  const data = localStorage.getItem('diary_user');
  return data ? JSON.parse(data) : null;
}

/** Remove user from localStorage (logout) */
function clearUser() {
  localStorage.removeItem('diary_user');
}

/** Redirect to login if not authenticated */
function requireAuth() {
  if (!getUser()) {
    window.location.href = 'login.html';
  }
}

/** Redirect to dashboard if already logged in */
function redirectIfLoggedIn() {
  if (getUser()) {
    window.location.href = 'dashboard.html';
  }
}

// ─── UI Helpers ──────────────────────────────────────────────────────────────

/** Show an alert message on the page */
function showAlert(elementId, message, type = 'error') {
  const el = document.getElementById(elementId);
  if (!el) return;
  el.textContent = message;
  el.className = `alert alert-${type} show`;
  // Auto-hide success messages
  if (type === 'success') {
    setTimeout(() => { el.className = 'alert'; }, 4000);
  }
}

/** Show loading state on a button */
function setLoading(btn, isLoading) {
  if (isLoading) {
    btn.dataset.originalText = btn.innerHTML;
    btn.innerHTML = '<span class="spinner"></span>';
    btn.disabled = true;
  } else {
    btn.innerHTML = btn.dataset.originalText || 'Submit';
    btn.disabled = false;
  }
}

/** Format a datetime string to readable date */
function formatDate(dateStr) {
  if (!dateStr) return '';
  const d = new Date(dateStr);
  return d.toLocaleDateString('en-IN', { day: 'numeric', month: 'long', year: 'numeric' });
}

/** Get initials from a name */
function getInitials(name) {
  if (!name) return '?';
  return name.split(' ').map(w => w[0]).join('').toUpperCase().slice(0, 2);
}

// ─── API: Users ──────────────────────────────────────────────────────────────

/** Register a new user */
async function registerUser(userData) {
  const res = await fetch(`${API_BASE}/users`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(userData)
  });
  const data = await res.json();
  if (!res.ok) throw new Error(data.message || JSON.stringify(data));
  return data;
}

/** Login a user by email + password */
async function loginUser(credentials) {
  const res = await fetch(`${API_BASE}/users/login`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(credentials)
  });
  const data = await res.json();
  if (!res.ok) throw new Error(data.message || 'Login failed. Check your credentials.');
  return data;
}

// ─── API: Diaries ────────────────────────────────────────────────────────────

/** Fetch all diaries for a user */
async function getDiariesByUser(userId) {
  const res = await fetch(`${API_BASE}/diaries/user/${userId}`);
  if (!res.ok) throw new Error('Failed to load diaries.');
  return res.json();
}

/** Fetch a single diary by ID */
async function getDiaryById(id) {
  const res = await fetch(`${API_BASE}/diaries/${id}`);
  if (!res.ok) throw new Error('Diary not found.');
  return res.json();
}

/** Create a new diary entry */
async function createDiary(diaryData) {
  const res = await fetch(`${API_BASE}/diaries`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(diaryData)
  });
  const data = await res.json();
  if (!res.ok) throw new Error(data.message || 'Failed to create diary.');
  return data;
}

/** Update an existing diary entry */
async function updateDiary(id, diaryData) {
  const res = await fetch(`${API_BASE}/diaries/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(diaryData)
  });
  const data = await res.json();
  if (!res.ok) throw new Error(data.message || 'Failed to update diary.');
  return data;
}

/** Delete a diary entry */
async function deleteDiary(id) {
  const res = await fetch(`${API_BASE}/diaries/${id}`, { method: 'DELETE' });
  if (!res.ok) throw new Error('Failed to delete diary.');
}

// ─── Navbar Init ─────────────────────────────────────────────────────────────

/** Update navbar based on login state */
function initNavbar() {
  const user = getUser();
  const navLinks = document.getElementById('navLinks');
  if (!navLinks) return;

  if (user) {
    navLinks.innerHTML = `
      <li><a href="dashboard.html">Dashboard</a></li>
      <li><a href="view-diaries.html">My Diaries</a></li>
      <li><a href="create-diary.html">New Entry</a></li>
      <li><a href="#" onclick="logout()" class="btn-nav">Logout</a></li>
    `;
  } else {
    navLinks.innerHTML = `
      <li><a href="login.html">Login</a></li>
      <li><a href="register.html" class="btn-nav">Get Started</a></li>
    `;
  }
}

/** Logout the user */
function logout() {
  clearUser();
  window.location.href = 'index.html';
}

// ─── Auto-init ───────────────────────────────────────────────────────────────
document.addEventListener('DOMContentLoaded', initNavbar);