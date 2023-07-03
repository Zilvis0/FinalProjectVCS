const images = document.querySelectorAll('.carousel img');

let index = 0;

let interval = setInterval(changeImage, 3000);

function changeImage() {


    images[index].classList.remove('active');

    index++;

    if (index == images.length) {
        index = 0;
    }

    images[index].classList.add('active');
}
