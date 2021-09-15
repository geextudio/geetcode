using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using Xamarin.Forms.Maps;
using TripLog.Models;
using TripLog.ViewModels;

namespace TripLog.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class TripLogDetailPage : ContentPage
    {
        public TripLogDetailPage(TripLogEntry entryItem)
        {
            InitializeComponent();

            BindingContext = new TripLogDetailViewModel(entryItem);


            // TBD:
            TripLogMap.MoveToRegion(MapSpan.FromCenterAndRadius(
                    new Position(entryItem.Latitude, entryItem.Longitude),
                    Distance.FromMiles((.5))
                ));
            TripLogMap.Pins.Add(new Pin
            {
                Type = PinType.Place,
                Label = entryItem.Title,
                Position = new Position(entryItem.Latitude, entryItem.Longitude)
            });

            Title.Text = entryItem.Title;
            Date.Text = entryItem.Date.ToString("M");
            Rating.Text = $"{entryItem.Rating} start rating";
            Notes.Text = entryItem.Notes;
        }
    }
}