# Generated by Django 4.1.2 on 2022-11-10 20:16

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('db_api', '0007_user_is_deleted'),
    ]

    operations = [
        migrations.RenameField(
            model_name='user',
            old_name='middle_name',
            new_name='patronymic',
        ),
    ]
