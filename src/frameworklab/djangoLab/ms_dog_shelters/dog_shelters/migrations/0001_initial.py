# Generated by Django 4.0.4 on 2022-04-25 03:14

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Shelter',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=200)),
                ('location', models.CharField(max_length=200)),
            ],
        ),
        migrations.CreateModel(
            name='Dog',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=200)),
                ('description', models.TextField()),
                ('intake_date', models.DateTimeField(auto_now_add=True)),
                ('shelter', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='dog_shelters.shelter')),
            ],
        ),
    ]
