// ==============================
// Initialize Lucide Icons
// ==============================

lucide.createIcons();

// ==============================
// Search Button
// ==============================

const searchButton = document.querySelector(".search-container button");

if (searchButton) {

    searchButton.addEventListener("click", () => {

        alert("Job search functionality will be connected to the backend.");

    });

}

// ==============================
// Smooth Fade-in Animation
// ==============================

const observer = new IntersectionObserver((entries) => {

    entries.forEach(entry => {

        if (entry.isIntersecting) {

            entry.target.classList.add("show");

        }

    });

}, {

    threshold:0.2

});

document.querySelectorAll("section").forEach(section=>{

    section.classList.add("fade-up");

    observer.observe(section);

});