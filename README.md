# Some links on Git hooks
https://www.baeldung.com/ops/git-hooks-creation
https://medium.com/google-developer-experts/using-git-hooks-to-improve-your-development-workflow-8f5a1fb81ec7
https://www.redhat.com/en/blog/git-hooks



# Let’s see an example diagram with some common hook types and where they run:


Remote Repository
+---------------------------------+
|         [+] post-receive        |
|          ^                      |
|          |                      |
|          +------+               |
|          |Remote|               |
|          |Origin|               |
|          +------+               |
|          ^                      |
|          |                      |
|         [+] update              |
|         [+] pre-receive         |
|          ^                      |
+--|Push|-------------------------+
|          ^                      |
|          |                      |
|         [+] pre-push            |
|          ^                      |
|          |                      |
|         ...                     |
|         [+] post-commit         |
|          ^                      |
|          |                      |
|  Commit [+] commit-msg          |
|          ^                      |
|          |                      |
|         [+] prepare-commit-msg  |
|         [+] pre-commit          |
|          ^                      |
|          |                      |
|          +------+               |
|          |Commit|               |
|          | Data |               |
|          +------+               |
+---------------------------------+ 
Local Repository