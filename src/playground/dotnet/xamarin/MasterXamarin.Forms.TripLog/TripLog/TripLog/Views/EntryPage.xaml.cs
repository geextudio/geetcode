using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

using TripLog.Models;

namespace TripLog.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class EntryPage : ContentPage
    {
        public EntryPage()
        {
            InitializeComponent();


            var items = new List<TripLogEntry> 
            {
                new TripLogEntry
                {
                    Title = "Washington Monument",
                    Notes = "Amazing!",
                    Rating = 3,
                    Date = new DateTime(2019, 2, 5),
                    Latitude = 38.8895,
                    Longitude = -77.0352
                },
                new TripLogEntry
                {
                    Title = "Statue of Liberty",
                    Notes = "Inspiring!",
                    Rating = 4,
                    Date = new DateTime(2019, 4, 13),
                    Latitude = 40.6892,
                    Longitude = -74.0444
                },
                new TripLogEntry
                {
                    Title = "Golden Gate Bridge",
                    Notes = "Foggy, but beautiful.",
                    Rating = 5,
                    Date = new DateTime(2019, 4, 26),
                    Latitude = 37.8268,
                    Longitude = -122.4798
                },
                new TripLogEntry
                {
                    Title = "斜塘老街",
                    Notes = "小吃与美食在一条街上竞争.",
                    Rating = 5,
                    Date = new DateTime(2021, 4, 26),
                    Latitude = 37.8268,
                    Longitude = 122.4798
                },
            };

            trips.ItemsSource = items;
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