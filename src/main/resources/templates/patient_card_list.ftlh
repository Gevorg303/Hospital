<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список карточек пациентов</title>
</head>
<body>
<h1>Список карточек пациентов</h1>
<ul>
    <#list patientCardList as card>
    <li>${card.surname} ${card.name} ${card.patronymic}</li>
</#list>
</ul>
</body>
</html>
