using MyXamarinAppFlyout.ViewModels;
using System.ComponentModel;
using Xamarin.Forms;

namespace MyXamarinAppFlyout.Views
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