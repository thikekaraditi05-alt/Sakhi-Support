// ==========================================
// INITIALIZE LUCIDE ICONS
// ==========================================

lucide.createIcons();


// ==========================================
// CONTACT FORM
// ==========================================

const contactForm = document.getElementById("contactForm");

if (contactForm) {

    contactForm.addEventListener("submit", function (event) {

        event.preventDefault();

        // Get form values
        const name = document.getElementById("name").value.trim();
        const email = document.getElementById("email").value.trim();
        const subject = document.getElementById("subject").value;
        const message = document.getElementById("message").value.trim();
        const privacy = document.getElementById("privacy").checked;


        // Basic validation
        if (name === "") {
            alert("Please enter your name.");
            return;
        }

        if (email === "") {
            alert("Please enter your email address.");
            return;
        }

        if (subject === "") {
            alert("Please select a subject.");
            return;
        }

        if (message === "") {
            alert("Please enter your message.");
            return;
        }

        if (!privacy) {
            alert("Please agree to be contacted regarding your inquiry.");
            return;
        }


        // Success message
        alert(
            "Thank you, " + name + "!\n\n" +
            "Your message has been submitted successfully.\n" +
            "Our team will get back to you within 24–48 hours."
        );


        // Reset form
        contactForm.reset();

    });

}


// ==========================================
// SMOOTH SCROLL
// ==========================================

document.querySelectorAll('a[href^="#"]').forEach(function (link) {

    link.addEventListener("click", function (event) {

        const targetId = this.getAttribute("href");

        if (targetId === "#") {
            return;
        }

        const target = document.querySelector(targetId);

        if (target) {

            event.preventDefault();

            target.scrollIntoView({
                behavior: "smooth",
                block: "start"
            });

        }

    });

});