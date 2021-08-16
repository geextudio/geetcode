using GeexInApp.ViewModels;
using System.ComponentModel;
using Xamarin.Forms;

namespace GeexInApp.Views
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