var animatedText = document.getElementById('animatedText');
const textArray = [
    'npm install',
    '`installing components...`',
    '`Fetching from source...`'
];
const speed = 40; // скорость набора

function typeText(text, index, callback) {
    if (index < text.length) {
        animatedText.innerHTML += text.charAt(index);
        index++;
        setTimeout(function() {
            typeText(text, index, callback);
        }, speed);
    } else {
        setTimeout(callback, 1000); // пауза после завершения набора текста
    }
}

function startAnimation() {
    animatedText.innerHTML = '';
    var currentIndex = 0;

    function typeNextText() {
        typeText(textArray[currentIndex], 0, function() {
            currentIndex++;
            if (currentIndex < textArray.length) {
                setTimeout(typeNextText, 1000); // пауза перед началом следующего текста
            } else {
                setTimeout(startAnimation, 1000); // начать заново после завершения всех текстов
            }
        });
    }

    typeNextText();
}

startAnimation(); // начать анимацию