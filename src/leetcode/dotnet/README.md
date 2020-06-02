# Leetcode 的 C# 实现

本项目基于 [.NET Core 3.x+](https://dotnet.microsoft.com/download), 用到了 [Xunit.Gherkin.Quick](https://github.com/ttutisani/Xunit.Gherkin.Quick), 以实现 BDD.

## 项目创建

创建一个 .NET Core 库工程

```bash
dotnet new classlib --name=LeetcodeProblems
```

添加对 [Xunit.Gherkin.Quick](https://github.com/ttutisani/Xunit.Gherkin.Quick) 的引用

```bash
cd LeetcodeProblems
dotnet add package Xunit.Gherkin.Quick
```

在项目文件 .csproj 中 <ItemGroup> 节点增加节点

```xml
<None Update=".\**\*.feature">
  <CopyToOutputDirectory>PreserveNewest</CopyToOutputDirectory>
</None>
```

## 还原项目

```bash
cd LeetcodeProblems
dotnet restore
```
