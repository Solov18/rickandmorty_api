// Функция для отправки запроса к API и обработки данных
function fetchCharacters() {
    fetch('https://rickandmortyapi.com/api/character/{id}')
        .then(response => response.json())
        .then(data => {
            // Создаем элементы для отображения данных
            const characterDiv = document.createElement('div');
            const name = document.createElement('h2');
            const image = document.createElement('img');

            // Заполняем элементы данными из JSON
            name.textContent = data.name;
            image.src = data.image;
            image.alt = data.name;

            // Добавляем элементы на страницу
            characterDiv.appendChild(name);
            characterDiv.appendChild(image);
            document.getElementById('characters').appendChild(characterDiv);
        })
        .catch(error => {
            console.error('Error fetching characters:', error);
        });
}

// Вызываем функцию fetchCharacters() при загрузке страницы
window.onload = fetchCharacters;