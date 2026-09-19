const sakhiRobot = document.getElementById("sakhiRobot");

if (sakhiRobot) {

    lottie.loadAnimation({
        container: sakhiRobot,
        renderer: "svg",
        loop: true,
        autoplay: true,

        path: "../animations/sakhi-robot.json"
    });
}
/* ===================================================
                SAKHI AI CHATBOT
=================================================== */

const sakhiRobotButton = document.getElementById("chatbot-robot");
const sakhiChatbot = document.getElementById("sakhi-chatbot");
const closeChatbot = document.getElementById("close-chatbot");
const chatbotInput = document.getElementById("chatbot-input");
const sendMessage = document.getElementById("send-message");


/* Open chatbot */

if (sakhiRobotButton && sakhiChatbot) {

    sakhiRobotButton.addEventListener("click", function () {

        sakhiChatbot.classList.add("active");

    });
}


/* Close chatbot */

if (closeChatbot) {

    closeChatbot.addEventListener("click", function () {

        sakhiChatbot.classList.remove("active");

    });
}


/* Send message */

if (sendMessage) {

    sendMessage.addEventListener("click", async function () {

        const text = chatbotInput.value.trim();
        if (!text) return;

        const token = localStorage.getItem("sakhi_token");
        const userId = localStorage.getItem("sakhi_userId");

        if (!token) {
            appendMessage("bot", "Please log in first to use the chatbot.");
            return;
        }

        appendMessage("user", text);
        chatbotInput.value = "";

        try {
            const res = await fetch("http://localhost:8080/api/chat", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + token
                },
                body: JSON.stringify({ userId: Number(userId), message: text })
            });

            const data = await res.json();
            appendMessage("bot", data.reply);

        } catch (err) {
            appendMessage("bot", "Sorry, something went wrong. Please try again.");
            console.error(err);
        }
    });
}

function appendMessage(sender, text) {
    const div = document.createElement("div");
    div.className = "chatbot-msg " + sender;
    div.textContent = text;
    document.getElementById("chatbot-messages").appendChild(div);
    document.getElementById("chatbot-messages").scrollTop = document.getElementById("chatbot-messages").scrollHeight;
}
if (chatbotInput) {

    chatbotInput.addEventListener("keypress", function (e) {
        if (e.key === "Enter") {
            e.preventDefault();
            sendMessage.click();
        }
    });
}