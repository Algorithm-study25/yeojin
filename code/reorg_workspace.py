from pathlib import Path
import re
import shutil

root = Path(r'd:\codingtest\yeojin\code')
java_root = root / 'java'
py_root = root / 'python'

targets = [
    java_root / 'baekjoon',
    java_root / 'programmers-school',
    java_root / 'leetcode',
    py_root / 'baekjoon',
    py_root / 'programmers-school',
    py_root / 'leetcode',
]
for d in targets:
    d.mkdir(parents=True, exist_ok=True)


def move_dir(src, dst_root):
    dst = dst_root / src.name
    if dst.exists():
        for item in list(src.iterdir()):
            if item.is_dir():
                move_dir(item, dst)
            else:
                target = dst / item.name
                if target.exists():
                    target.unlink()
                item.replace(target)
        try:
            src.rmdir()
        except OSError:
            pass
    else:
        src.replace(dst)


def move_file(src, dst_root):
    dst_root.mkdir(parents=True, exist_ok=True)
    target = dst_root / src.name
    if target.exists():
        target.unlink()
    src.replace(target)


def classify_java_file(f):
    if set(f.parts) & {'baekjoon', 'programmers-school', 'leetcode'}:
        return None
    if re.match(r'^B\d+$', f.parent.name):
        return java_root / 'baekjoon' / f.parent.name
    if re.match(r'^P', f.parent.name):
        return java_root / 'programmers-school' / f.parent.name
    if re.match(r'^L', f.parent.name):
        return java_root / 'leetcode' / f.parent.name
    name = f.stem
    if re.match(r'^L', name):
        return java_root / 'leetcode'
    if re.match(r'^[B\d]', name):
        return java_root / 'baekjoon'
    if re.match(r'^P', name) or re.search('[\uac00-\ud7a3]', name) or any(x.lower() in {'programmers', 'hash'} for x in f.parts):
        return java_root / 'programmers-school'
    return None


def classify_python_file(f):
    if set(f.parts) & {'baekjoon', 'programmers-school', 'leetcode'}:
        return None
    name = f.stem
    if re.match(r'^L', name):
        return py_root / 'leetcode'
    if re.match(r'^[B\d]', name):
        return py_root / 'baekjoon'
    if re.match(r'^P', name) or re.search('[\uac00-\ud7a3]', name):
        return py_root / 'programmers-school'
    return None


for path in sorted(java_root.rglob('*'), key=lambda p: (-len(p.parts), str(p))):
    if path == java_root:
        continue
    if set(path.parts) & {'baekjoon', 'programmers-school', 'leetcode'}:
        continue
    if path.is_dir():
        if re.match(r'^B\d+$', path.name):
            move_dir(path, java_root / 'baekjoon')
        elif re.match(r'^P', path.name):
            move_dir(path, java_root / 'programmers-school')
        elif re.match(r'^L', path.name):
            move_dir(path, java_root / 'leetcode')
    elif path.is_file() and path.suffix == '.java':
        dest = classify_java_file(path)
        if dest:
            move_file(path, dest)

programmers_basic = java_root / 'programmers' / 'basic'
if programmers_basic.exists():
    for f in programmers_basic.glob('*.java'):
        move_file(f, java_root / 'programmers-school')

programmers_leet = java_root / 'programmers' / '리트코드'
if programmers_leet.exists():
    for f in programmers_leet.glob('*.java'):
        move_file(f, java_root / 'leetcode')

hash_dir = java_root / 'hash'
if hash_dir.exists():
    for path in sorted(hash_dir.rglob('*'), key=lambda p: (-len(p.parts), str(p))):
        if path.is_dir() and re.match(r'^P', path.name):
            move_dir(path, java_root / 'programmers-school')
        elif path.is_file() and path.suffix == '.java':
            move_file(path, java_root / 'programmers-school')

for f in sorted(java_root.rglob('*.java'), key=lambda p: (len(p.parts), str(p))):
    if set(f.parts) & {'baekjoon', 'programmers-school', 'leetcode'}:
        continue
    dest = classify_java_file(f)
    if dest:
        move_file(f, dest)

for path in sorted(java_root.rglob('*'), key=lambda p: (-len(p.parts), str(p))):
    if path.is_dir() and path.name not in {'baekjoon', 'programmers-school', 'leetcode'} and not any(path.iterdir()):
        path.rmdir()

for f in sorted(py_root.rglob('*.py'), key=lambda p: (len(p.parts), str(p))):
    if set(f.parts) & {'baekjoon', 'programmers-school', 'leetcode'}:
        continue
    dest = classify_python_file(f)
    if dest:
        move_file(f, dest)

for path in sorted(py_root.rglob('*'), key=lambda p: (-len(p.parts), str(p))):
    if path.is_dir() and path.name not in {'baekjoon', 'programmers-school', 'leetcode'} and not any(path.iterdir()):
        path.rmdir()

print('done')
