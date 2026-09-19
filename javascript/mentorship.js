// ===============================
// Initialize Lucide Icons
// ===============================

lucide.createIcons();

// ===============================
// Smooth Scroll
// ===============================

document.querySelectorAll('a[href^="#"]').forEach(link => {

    link.addEventListener("click", function (e) {

        const target = document.querySelector(this.getAttribute("href"));

        if (target) {

            e.preventDefault();

            target.scrollIntoView({
                behavior: "smooth"
            });

        }

    });

});

// ===============================
// Mentor Search
// ===============================

const searchButton = document.querySelector(".search-container button");

if (searchButton) {

    searchButton.addEventListener("click", function () {

        const skillInput = document.querySelector(".search-container input");

        if (skillInput.value.trim() === "") {

            alert("Please enter a skill or mentor name.");

            return;

        }

        alert(
            "Searching mentors for: " + skillInput.value +
            "\n\nBackend integration will be added later."
        );

    });

}

// ===============================
// Book Session Buttons
// ===============================

const bookButtons = document.querySelectorAll(".book-btn");

bookButtons.forEach(button => {

    button.addEventListener("click", function (e) {

        e.preventDefault();

        alert(
            "Booking functionality will be available after backend integration."
        );

    });

});

// ===============================
// Become Mentor Button
// ===============================

const mentorButton = document.querySelector(".mentor-btn");

if (mentorButton) {

    mentorButton.addEventListener("click", function () {

        window.location.href = "becomementor.html";

    });

}