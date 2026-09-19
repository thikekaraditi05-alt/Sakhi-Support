/* ===================================================
                COMMUNITY PAGE JAVASCRIPT
=================================================== */


/* ===================================================
                LUCIDE ICONS
=================================================== */

document.addEventListener("DOMContentLoaded", function () {

    if (typeof lucide !== "undefined") {
        lucide.createIcons();
    }

});


/* ===================================================
                DISCUSSION FORM
=================================================== */

const discussionForm = document.getElementById("discussionForm");

if (discussionForm) {

    discussionForm.addEventListener("submit", function (event) {

        event.preventDefault();

        const title = document.getElementById("discussionTitle").value.trim();
        const category = document.getElementById("discussionCategory").value;
        const description = document.getElementById("discussionDescription").value.trim();

        if (title === "" || category === "" || description === "") {

            alert("Please fill in all the required fields.");

            return;
        }

        alert(
            "Your discussion has been submitted successfully!"
        );

        discussionForm.reset();

    });

}


/* ===================================================
                VIEW ALL DISCUSSIONS
=================================================== */

const viewAllBtn = document.getElementById("viewAllBtn");

if (viewAllBtn) {

    viewAllBtn.addEventListener("click", function () {

        const hiddenDiscussions =
            document.querySelectorAll(".discussion-card.hidden");

        hiddenDiscussions.forEach(function (discussion) {

            discussion.classList.remove("hidden");

        });

        viewAllBtn.style.display = "none";

    });

}


/* ===================================================
                TOPIC FILTER
=================================================== */

const topics = document.querySelectorAll(".topics span");

topics.forEach(function (topic) {

    topic.addEventListener("click", function () {

        const selectedTopic = topic.textContent.trim();

        alert(
            "You selected the topic: " + selectedTopic
        );

    });

});


/* ===================================================
                DISCUSSION BUTTONS
=================================================== */

const discussionButtons =
    document.querySelectorAll(".discussion-btn");

discussionButtons.forEach(function (button) {

    button.addEventListener("click", function (event) {

        event.preventDefault();

        alert(
            "Discussion feature will be available after login."
        );

    });

});


/* ===================================================
                CTA BUTTON
=================================================== */

const ctaButton = document.querySelector(".cta-btn");

if (ctaButton) {

    ctaButton.addEventListener("click", function (event) {

        const target = document.querySelector("#discussionForm");

        if (target) {

            event.preventDefault();

            target.scrollIntoView({
                behavior: "smooth"
            });

        }

    });

}


/* ===================================================
                SMOOTH SCROLL
=================================================== */

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