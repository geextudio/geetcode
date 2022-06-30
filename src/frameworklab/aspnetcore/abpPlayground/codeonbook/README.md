# Code on Book
---

### Introduciton
The code projects in this folder is a practice following the book [Mastering ABP Framework](https://www.amazon.com/Mastering-ABP-Framework-maintainable-implementing-ebook/dp/B097Z2DM8Q) 

### Environment
* .NET 6 SDK
* abp cli 5.3.1
* run the following cmd to hide db connection credentials in ./ProductManagement/src/ 
    ```
    git update-index --assume-unchanged ./ProductManagement.DbMigrator/appsettings.json 
    git update-index --assume-unchanged ./ProductManagement.Web/appsettings.json 
    ```
