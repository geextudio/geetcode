from django.db import models
from django.urls import reverse

# Create your models here.
class Shelter(models.Model):
    name = models.CharField(max_length=200)
    location = models.CharField(max_length=200)

    def __str__(self):
        return self.name

class Dog(models.Model):
    
    name = models.CharField(max_length=200)
    description = models.TextField()
    intake_date = models.DateTimeField(auto_now_add=True)
    
    # Shelter is a foreignkey field
    # This part tells Django there's a relationship between Dog and Shelter.
    shelter = models.ForeignKey(Shelter, on_delete=models.PROTECT)

    def __str__(self):
        return self.name

    def get_absolute_url(self):
        return reverse('dog_detail_path', kwargs={"pk": self.pk})
