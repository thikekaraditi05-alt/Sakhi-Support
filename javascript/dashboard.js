// Lucide Icons
lucide.createIcons();

// ============================
// Card Hover Animation
// ============================

const cards = document.querySelectorAll(".card,.course-card,.job-card");

cards.forEach(card=>{

    card.addEventListener("mouseenter",()=>{

        card.style.transform="translateY(-10px)";

    });

    card.addEventListener("mouseleave",()=>{

        card.style.transform="translateY(0)";

    });

});

// ============================
// Counter Animation
// ============================

const numbers=document.querySelectorAll(".card h2");

numbers.forEach(counter=>{

    const target=parseInt(counter.innerText);

    let count=0;

    const speed=40;

    const update=()=>{

        if(count<target){

            count++;

            counter.innerText=count;

            setTimeout(update,speed);

        }

    };

    update();

});

// ============================
// Button Click Animation
// ============================

document.querySelectorAll("button").forEach(btn=>{

    btn.addEventListener("click",()=>{

        btn.style.transform="scale(.95)";

        setTimeout(()=>{

            btn.style.transform="scale(1)";

        },150);

    });

});