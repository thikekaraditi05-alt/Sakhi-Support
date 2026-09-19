// =============================
// Initialize Lucide Icons
// =============================

lucide.createIcons();

// =============================
// Mentor Application Form
// =============================

const mentorForm = document.querySelector(".mentor-form");

if (mentorForm) {

    mentorForm.addEventListener("submit", function (e) {

        e.preventDefault();

        alert(
            "🎉 Your mentor application has been submitted successfully!\n\n" +
            "Thank you for applying to become a mentor at Sakhi Support.\n\n" +
            "Our team will review your application and contact you within 3–5 working days."
        );

        mentorForm.reset();

    });

}

// =============================
// Smooth Scroll for Buttons
// =============================

document.querySelectorAll('a[href^="#"]').forEach(anchor => {

    anchor.addEventListener("click", function (e) {

        e.preventDefault();

        const target = document.querySelector(this.getAttribute("href"));

        if (target) {

            target.scrollIntoView({

                behavior: "smooth"

            });

        }

    });

});