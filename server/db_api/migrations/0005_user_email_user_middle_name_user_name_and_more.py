# Generated by Django 4.1.2 on 2022-11-10 07:59

from django.db import migrations, models
import django.db.models.deletion
import django.utils.timezone


class Migration(migrations.Migration):

    dependencies = [
        ('db_api', '0004_remove_user_email_remove_user_middle_name_and_more'),
    ]

    operations = [
        migrations.AddField(
            model_name='user',
            name='email',
            field=models.EmailField(default='', max_length=254),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='user',
            name='middle_name',
            field=models.CharField(default='', max_length=45),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='user',
            name='name',
            field=models.CharField(default='', max_length=45),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='user',
            name='phone_number',
            field=models.CharField(blank=True, max_length=15, null=True),
        ),
        migrations.AddField(
            model_name='user',
            name='projects',
            field=models.ManyToManyField(blank=True, null=True, to='db_api.project'),
        ),
        migrations.AddField(
            model_name='user',
            name='roles',
            field=models.ManyToManyField(blank=True, null=True, to='db_api.role'),
        ),
        migrations.AddField(
            model_name='user',
            name='surname',
            field=models.CharField(default='', max_length=45),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='user',
            name='telegram_id',
            field=models.CharField(blank=True, max_length=255, null=True),
        ),
        migrations.AddField(
            model_name='user',
            name='vk_id',
            field=models.CharField(blank=True, max_length=255, null=True),
        ),
        migrations.AlterField(
            model_name='task',
            name='close_date',
            field=models.DateTimeField(blank=True, default=django.utils.timezone.now, null=True),
        ),
        migrations.AlterField(
            model_name='task',
            name='create_date',
            field=models.DateTimeField(default=django.utils.timezone.now),
        ),
        migrations.AlterField(
            model_name='task',
            name='end_date',
            field=models.DateTimeField(default=django.utils.timezone.now),
        ),
        migrations.AlterField(
            model_name='task',
            name='performer',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.SET_NULL, related_name='performer', to='db_api.user'),
        ),
        migrations.AlterField(
            model_name='task',
            name='start_date',
            field=models.DateTimeField(blank=True, default=django.utils.timezone.now, null=True),
        ),
    ]
