using System;
using System.Linq;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

using TripLog.Models;
using TripLog.ViewModels;

namespace TripLog.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class EntryPage : ContentPage
    {
        public EntryPage()
        {
            InitializeComponent();

            BindingContext = new EntryViewModel();
            
        }

        private void NewTripLog_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new NewTripLogPage());
        }

        private async void trips_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var tripEntryItem = e.CurrentSelection.FirstOrDefault() as TripLogEntry;
            if(tripEntryItem != null)
            {
                await Navigation.PushAsync(new TripLogDetailPage(tripEntryItem));
            }

            //Clear Selection
            trips.SelectedItem = null;
        }
    }
}