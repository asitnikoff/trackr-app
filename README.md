# Trackr

## 1. Описание

Trackr - мобильное приложение, созданное/создаваемое с целью упростить командную разработку проектов/продуктов.

## 2. Типы пользователей

Есть менеджер, разработчик и главный разработчик:

- Менеджер может добавлять задачи, создавать категории и добавлять/удалять разработчиков из проектов. Менеджер может принадлежать нескольким отделам разработчиков.
- Разработчик может только брать задачу в своё выполнение. Каждый разработчик может принадлежать нескольким отделам разработчиков и занимает только одну позицию.
- Главный разработчик может добавлять/брать задачи и создавать категории. Каждый главный разработчик может принадлежать нескольким отделам разработчиков и занимает только одну позицию.

P.S. далее тот, кто создаёт задачу, будет называться Автором.

## 3. Функционал приложения

1. Функционал авторизации, регистрации и аутентификации.
2. Функционал создания задачи.
3. Функционал создания категории.
4. Функционал назначения задачи.
5. Функционал удаления задачи.
6. Функционал редактирования задачи.
7. Функционал просмотра задачи.
8. Функционал личного кабинета.

### 3.1 Функционал регистрации, аутентификации и авторизации

Во время регистрации в Системе разработчик указывает:

- Имя
- Фамилию
- Позицию
- Отдел(-ы)
- Почту
- Телефон
- Контактные данные в социальных сетях (опционально)
- Логин (никнейм)
- Пароль
- Подтверждение пароля

Если всё введено корректно, то заявка на регистрацию отправляется менеджеру/главному разработчику и тот в свою очередь её либо одобряет, либо отклоняет. После одобрения заявки, разработчик может войти в свой аккаунт и пользоваться функционалом.

Для успешной авторизации пользователю необходимо пройти аутентификацию, введя почту/никнейм и пароль.

### 3.2 Функционал создания задачи

При создании задачи необходимо заполнить следующие данные:

1. Название задачи
2. Отдел, куда относится данная задача
3. Метка задачи (баг, фича, улучшение, рефакторинг)
4. Приоритет задачи (от низкого до высокого)
5. Описание задачи (в чём проблема, какие варианты решения и т.д.)

После создания задачи она объявляется открытой и разработчик может взять эту задачу под своё выполнение. Номер задачи задаётся в виде "category_name#task_number", где category_name - короткое название категории, а task_number - общий номер задачи (если это первая задача, то номер будет 1, если вторая, то 2 и т.д.)

### 3.3 Функционал создания категории

Автор может создать категорию задач. Например, фронтенд-задачи, бэкенд-задачи, дизайн-задачи и т.д. Также Автор может добавить определенных разработчиков в данные категории. У каждой категории должно быть короткое название.

### 3.4 Функционал назначения задачи

Каждый разработчик может выбрать интересную/нужную ему задачу и назначить её себе, тем самым обозначив, что он будет её выполнять. Если вдруг какой-то разработчик назначил себе задачу, то другой разработчик не может сделать то же самое. Переназначить задачу может либо Автор, либо разработчик, который взял эту задачу, снимает с себя эту задачу, а новый разработчик берёт себя. Но когда разработчик снимает с себя эту задачу, он должен объяснить причину, почему не может её выполнить.

### 3.5 Функционал удаления задачи

Если вдруг окажется, что задача неактуальная/ненужная, то её можно удалить.

### 3.6 Функционал редактирования задачи

Автор или разработчик, кому назначена та или иная задача, может её отредактировать. Например, поменять описание, внеся корректировки.

### 3.7 Функционал просмотра задачи

Страница задачи будет выглядить следующим образом:

1. Номер задачи
2. Название задачи
3. Отдел задачи
4. Метка задачи
5. Приоритет задачи
6. Описание задачи
7. Комментарии

Комментарии будут открываться при нажатии на отдельную кнопку.

### 3.8 Функционал личного кабинета

Личный кабинет будет включать в себя следующую информацию:

- Имя
- Фамилию
- Позицию
- Отдел(-ы)
- Почту
- Телефон
- Контактные данные в социальных сетях (опционально)
- Кнопка изменения пароля

## 4. Стек используемых технологий

В настоящее время планирую реализовать данное приложение с использованием **Kotlin** и используя базу данных **SQL**.
