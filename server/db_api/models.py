from django.db import models
from django.utils.timezone import now
import datetime

# Create your models here.


class Role(models.Model):
    role_id = models.AutoField(primary_key=True)
    title = models.CharField(max_length=60)

    def __str__(self):
        return self.title

    class Meta:
        verbose_name_plural = "Roles"


class Project(models.Model):
    project_id = models.AutoField(primary_key=True, unique=True)
    project_slug = models.CharField(max_length=10, default="empty")
    project_name = models.CharField(max_length=90, default="empty")
    description = models.TextField(default="empty")

    def __str__(self):
        return self.project_name

    class Meta:
        verbose_name_plural = "Projects"


class User(models.Model):
    user_id = models.AutoField(primary_key=True, unique=True)
    name = models.CharField(max_length=45)
    surname = models.CharField(max_length=45)
    patronymic = models.CharField(max_length=45)
    projects = models.ManyToManyField(Project, blank=True)
    email = models.EmailField(unique=True)
    phone_number = models.CharField(max_length=15, null=True, blank=True)
    telegram_id = models.CharField(max_length=255, null=True, blank=True)
    vk_id = models.CharField(max_length=255, null=True, blank=True)
    login = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    roles = models.ManyToManyField(Role, blank=True)
    is_deleted = models.BooleanField(default=False)

    def __str__(self):
        return f"{self.surname} {self.name} {self.patronymic}"

    class Meta:
        verbose_name_plural = "Users"


class Tag(models.Model):
    tag_id = models.AutoField(primary_key=True, unique=True)
    title = models.CharField(max_length=45)

    def __str__(self):
        return self.title

    class Meta:
        verbose_name_plural = "Tags"


class Priority(models.Model):
    priority_id = models.AutoField(primary_key=True, unique=True)
    title = models.CharField(max_length=45)

    def __str__(self):
        return self.title

    class Meta:
        verbose_name_plural = "Priorities"


class Task(models.Model):
    task_id = models.AutoField(primary_key=True)
    task_title = models.CharField(max_length=90)
    task_slug = models.CharField(max_length=20, unique=True, default="")
    # tags = models.ManyToManyField(Tag)
    description = models.TextField(default="")
    # create_date = models.DateTimeField(default=now)
    # end_date = models.DateTimeField(default=now)
    # start_date = models.DateTimeField(default=now, null=True, blank=True)
    # close_date = models.DateTimeField(default=now, null=True, blank=True)
    # performer = models.ForeignKey(
                            # User,
                            # null=True,
                            # blank=True,
                            # on_delete=models.SET_NULL,
                            # related_name='performer'
                        # )
    author = models.ForeignKey(
                            User,
                            on_delete=models.DO_NOTHING,
                            related_name='author',
                            null=True,
                            blank=True
                        )
    # priority = models.ForeignKey(
                            # Priority,
                            # on_delete=models.DO_NOTHING,
                        # )
    is_open = models.BooleanField(default=True)
    project = models.ForeignKey(
                            Project,
                            on_delete=models.DO_NOTHING
                        )

    def __str__(self):
        return self.task_title

    class Meta:
        verbose_name_plural = "Tasks"