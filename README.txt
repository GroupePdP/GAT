Paramétrage local de git :

git config --global user.name "votre-nom"
git config --global use.email "votre-email"

git config --global core.editor votre-editeur-texte
git config --global merge.tool outil-de-différences



Utilisation de git :

Creates a directory for your project called "Hello-World" in your user directory
mkdir ~/Hello-World

Changes the current working directory to your newly created directory
cd ~/Hello-World 

Initialized empty Git repository in /Users/you/Hello-World/.git/
git init

Creates a file called "README" in your Hello-World directory
touch README 

Stages your README file, adding it to the list of files to be committed
git add README

Commits your files, adding the message "first commit"
git commit -m 'first commit' 

Creates a remote named "origin" pointing at your GitHub repo
git remote add origin https://github.com/username/Hello-World.git 

Sends your commits in the "master" branch to GitHub
git push origin master 


(Source: https://help.github.com/articles/create-a-repo)


 
