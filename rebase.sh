#!/bin/bash

# Mr. O's Git History Rebaser 🧠⚡️

echo "🔐 Backing up current repo to ~/BankLedger_backup_$(date +%Y%m%d_%H%M%S)"
cp -R ./ ~/BankLedger_backup_$(date +%Y%m%d_%H%M%S)

echo "🧹 Starting non-interactive rebase..."
echo "👉 This will rewrite ALL commits from root using reword."

# Auto-change all 'pick' to 'reword'
GIT_SEQUENCE_EDITOR="sed -i '' 's/^pick /reword /'" git rebase -i --root

echo ""
echo "📌 Paste your new commit messages as Git prompts you."
echo "💡 Tip: You can use your clipboard manager or a .txt file."

echo ""
read -p "✅ Press [Enter] once you've completed all rewording and are ready to push..."

# Push forcefully to overwrite old history
echo "🚀 Pushing rewritten history to origin..."
git push --force

echo "✅ Done! Your commit history is now clean and professional."
echo "🗂️ A backup of your original repo is stored in your home folder."
