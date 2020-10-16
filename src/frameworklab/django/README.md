# Django 实践环境

## 搭建与启动环境

* Windows
```bash
python -m venv vgeekcode
.\vgeekcode\Scripts\activate
pip install --upgrade pip  -i https://pypi.tuna.tsinghua.edu.cn/simple
pip install -r requirements.txt  -i https://pypi.tuna.tsinghua.edu.cn/simple
```
* Linux / macOS
```bash
python3 -m venv vgeekcode
source ./vgeekcode/bin/activate
pip3 install --upgrade pip  -i https://pypi.tuna.tsinghua.edu.cn/simple
pip3 install -r requirements.txt  -i https://pypi.tuna.tsinghua.edu.cn/simple
```

## 实践

* [官网投票程序](https://docs.djangoproject.com/en/3.1/intro/tutorial01/)