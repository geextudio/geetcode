using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using Xamarin.Forms.Maps;

namespace GeexInApp.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class BingmapPage : ContentPage
    {
        public BingmapPage()
        {
            InitializeComponent();

            MyMap.MoveToRegion(
            MapSpan.FromCenterAndRadius(
                new Position(37, -122), Distance.FromMiles(1)));
        }
    }
}