using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using TripLog.Views;

namespace TripLog
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            // we are wrapping our MainPage with a NavigationPage.
            // By doing this, we automatically get native components for navigating between pages.

            //MainPage = new MainPage();
            MainPage = new NavigationPage(new EntryPage());
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}
