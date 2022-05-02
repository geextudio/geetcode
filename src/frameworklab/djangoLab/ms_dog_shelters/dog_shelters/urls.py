from django.urls import path
from . import views

urlpatterns = [
    path('', views.shelter_list, name='shelter_list'),
    path('shelter/<int:pk>', views.shelter_detail, name='shelter_detail_path'),

    #path('dog/<int:pk>', views.dog_detail, name='dog_detail'),
    # as_view() method to convert the class into a view.
    path('dog/<int:pk>', views.DogDetailView.as_view(), name='dog_detail_path'),
    
    path('dog/register', views.DogCreateView.as_view(), name='dog_register'),
]
