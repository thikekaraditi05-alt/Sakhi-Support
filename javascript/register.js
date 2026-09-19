// ===============================
// Lucide Icons
// ===============================

lucide.createIcons();

// ===============================
// Get Elements
// ===============================

const registerForm = document.getElementById("registerForm");

const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");

const togglePassword = document.getElementById("togglePassword");
const toggleConfirmPassword = document.getElementById("toggleConfirmPassword");

const phoneInput = document.querySelector("input[type='tel']");

// ===============================
// Show / Hide Password
// ===============================

togglePassword.addEventListener("click", () => {

    if(password.type === "password"){

        password.type = "text";

        togglePassword.innerHTML = `<i data-lucide="eye-off"></i>`;

    }

    else{

        password.type = "password";

        togglePassword.innerHTML = `<i data-lucide="eye"></i>`;

    }

    lucide.createIcons();

});

// ===============================
// Show / Hide Confirm Password
// ===============================

toggleConfirmPassword.addEventListener("click", () => {

    if(confirmPassword.type === "password"){

        confirmPassword.type = "text";

        toggleConfirmPassword.innerHTML = `<i data-lucide="eye-off"></i>`;

    }

    else{

        confirmPassword.type = "password";

        toggleConfirmPassword.innerHTML = `<i data-lucide="eye"></i>`;

    }

    lucide.createIcons();

});

// ===============================
// Phone Number Validation
// ===============================

phoneInput.addEventListener("input", () => {

    phoneInput.value = phoneInput.value.replace(/\D/g,"");

    if(phoneInput.value.length > 10){

        phoneInput.value = phoneInput.value.slice(0,10);

    }

});

// ===============================
// Password Strength
// ===============================

password.addEventListener("input", () => {

    const value = password.value;

    if(value.length < 6){

        password.style.borderColor = "red";

    }

    else if(value.length < 8){

        password.style.borderColor = "orange";

    }

    else{

        password.style.borderColor = "green";

    }

});

// ===============================
// Form Validation
// ===============================

registerForm.addEventListener("submit",(e)=>{

    e.preventDefault();

    if(phoneInput.value.length !== 10){

        alert("Phone number must contain exactly 10 digits.");

        return;

    }

    if(password.value.length < 8){

        alert("Password should be at least 8 characters long.");

        return;

    }

    if(password.value !== confirmPassword.value){

        alert("Passwords do not match.");

        return;

    }

    alert("Registration Successful! 🎉");

    registerForm.reset();

});