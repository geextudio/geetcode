from django.urls import path

from . import views

urlpatterns = [
    # 对应到 views.py 的 index 函数
    path('', views.index, name='index'),
]

