Write-Host "You are about to commit" $(git diff --cached --name-only --diff-filter=ACM)
Write-Host "To $(git branch --show-current)"
bla
exit 1
