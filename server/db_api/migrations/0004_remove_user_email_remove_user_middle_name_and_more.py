# Generated by Django 4.1.2 on 2022-11-08 17:03

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('db_api', '0003_priority_tag_user_task'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='user',
            name='email',
        ),
        migrations.RemoveField(
            model_name='user',
            name='middle_name',
        ),
        migrations.RemoveField(
            model_name='user',
            name='name',
        ),
        migrations.RemoveField(
            model_name='user',
            name='phone_number',
        ),
        migrations.RemoveField(
            model_name='user',
            name='projects',
        ),
        migrations.RemoveField(
            model_name='user',
            name='roles',
        ),
        migrations.RemoveField(
            model_name='user',
            name='surname',
        ),
        migrations.RemoveField(
            model_name='user',
            name='telegram_id',
        ),
        migrations.RemoveField(
            model_name='user',
            name='vk_id',
        ),
    ]
