# Leetcode 的 C# 实现

本项目基于 [.NET Core 3.x+](https://dotnet.microsoft.com/download), 用到了 [Xunit.Gherkin.Quick](https://github.com/ttutisani/Xunit.Gherkin.Quick), 以实现 BDD.

## 项目创建

创建一个 .NET Core 库工程和对应的测试工程

```bash
dotnet new sln -o LeetcodeSolutions
cd LeetcodeSolutions
dotnet new classlib -o LeetcodeProblems
dotnet new xunit -o LeetcodeProblems.Tests
dotnet sln add ./LeetcodeProblems/LeetcodeProblems.csproj
dotnet sln add ./LeetcodeProblems.Tests/LeetcodeProblems.Tests.csproj
dotnet add ./LeetcodeProblems.Tests/LeetcodeProblems.Tests.csproj reference ./LeetcodeProblems/LeetcodeProblems.csproj
```

添加对 [Xunit.Gherkin.Quick](https://github.com/ttutisani/Xunit.Gherkin.Quick) 的引用

```bash
cd LeetcodeProblems.Tests
dotnet add package Xunit.Gherkin.Quick
```

在项目文件 .csproj 中增加节点

```xml
<ItemGroup>
    <None Update=".\**\*.feature">
      <CopyToOutputDirectory>PreserveNewest</CopyToOutputDirectory>
    </None>
</ItemGroup>
```

## 还原项目

```bash
dotnet restore
```

## 测试项目

在更目录 LeetcodeSolutions 下执行 xUnit 的测试指令

```bash
dotnet test
```
