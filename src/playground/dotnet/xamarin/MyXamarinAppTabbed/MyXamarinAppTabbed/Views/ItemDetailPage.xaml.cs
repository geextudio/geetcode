using MyXamarinAppTabbed.ViewModels;
using System.ComponentModel;
using Xamarin.Forms;

namespace MyXamarinAppTabbed.Views
{
    public partial class ItemDetailPage : ContentPage
    {
        public ItemDetailPage()
        {
            InitializeComponent();
            BindingContext = new ItemDetailViewModel();
        }
    }
}