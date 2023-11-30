<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Пациент</h1><hr>
<h4>Список всех пациентов</h4>
<#list patientCardList as patientCard>
    <div>
        <p><b>${patientCard.surname}</b>${patientCard.name} ${patientCard.patronymic}| <a href="/patientCard/${patientCard.id}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Добавить пациента</h3>
<form action="/patientCard/create" method="post">
    Фамилия: <input type="text" name="surname"/><br><br>
    Имя: <input type="text" name="name"/><br><br>
    Отчество: <input type="text" name="patronymic"/><br><br>
    Пол: <input type="text" name="floor"/><br><br>
    Дата рождения: <input type="text" name="dateOfBirth"/><br><br>
    Номер телефона: <input type="text" name="phoneNumber"/><br><br>
    Серия и номер паспорта: <input type="text" name="passportSeriesNumber"/><br><br>

    <input type="submit" value="Добавить пациента">
</form>

</body>
</html>