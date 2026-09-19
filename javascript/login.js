const togglePassword = document.getElementById("togglePassword");
const password = document.getElementById("password");

togglePassword.addEventListener("click", () => {

    if(password.type === "password"){

        password.type = "text";

    }else{

        password.type = "password";

    }

});
const loginForm = document.querySelector("form");

if (loginForm) {
    loginForm.addEventListener("submit", async function (e) {
        e.preventDefault();

        const email = document.querySelector('input[name="email"]').value.trim();
        const pass = document.getElementById("password").value;

        try {
            const res = await fetch("http://localhost:8080/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ email: email, password: pass })
            });

            if (!res.ok) {
                alert("Login failed. Please check your email and password.");
                return;
            }

            const data = await res.json();

            // Save token and userId so other pages can use them
            localStorage.setItem("sakhi_token", data.token);
            localStorage.setItem("sakhi_userId", data.userId);
            localStorage.setItem("sakhi_name", data.fullName);

            window.location.href = "dashboard.html";

        } catch (err) {
            alert("Something went wrong. Please try again.");
            console.error(err);
        }
    });
}