# CS61B (SP21) 学习仓库

基于 Berkeley CS61B [skeleton-sp21](https://github.com/Berkeley-CS61B/skeleton-sp21) 的个人练习仓库，包含 lab1–lab8、proj0–proj3，以及课程依赖 submodule。

## 克隆

```bash
git clone --recurse-submodules https://github.com/Seeleelysiahua/CS61B.git
```

如果已经克隆但还没有初始化 submodule：

```bash
git submodule update --init --recursive
```

## 目录

- `lab1`–`lab8`：课程 lab
- `proj0`–`proj3`：课程 project
- `library-sp21`：课程依赖（submodule）
- `LectureAnddiscusioncode`：课堂与讨论课示例

## 构建与测试

每个 lab/project 目录下通常有 `Makefile`，例如：

```bash
cd proj2
make check
```

具体目标以各目录的 `Makefile` 为准。

## 说明

课程 skeleton 与课程资料版权归 UC Berkeley CS61B 课程组所有；本仓库仅用于个人学习，不用于分发课程材料。
