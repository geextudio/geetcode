from django.shortcuts import render, get_object_or_404
from django.views import generic
from .models import Shelter, Dog

# Create your views here.
def shelter_list(request):
    shelters = Shelter.objects.all()
    context = { 'shelters': shelters }
    return render(request, 'shelter_list.html', context)

def shelter_detail(request, pk):
    shelter = get_object_or_404(Shelter, pk=pk)
    context = {'shelter': shelter}
    return render(request, 'shelter_detail.html', context)

def dog_detail(request, pk):
    dog = get_object_or_404(Dog, pk=pk)
    context = {'dog': dog}
    return render(request, 'dog_detail.html', context)

class DogDetailView(generic.DetailView):
    model = Dog
    template_name = 'dog_detail.html'
    context_object_name = 'dog'
class DogCreateView(generic.CreateView):
    model = Dog
    template_name = 'dog_form.html'
    # fields property where you list the editable fields
    fields = ['name', 'description', 'shelter']

class DogUpdateView(generic.CreateView):
    model = Dog
    template_name = 'dog_form.html'
    # fields property where you list the editable fields
    fields = ['name', 'description', 'shelter']