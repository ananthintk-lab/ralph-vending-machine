#!/bin/bash
set -e

if [ -z "$1" ]; then
  echo "Usage: $0 <iterations>"
  exit 1
fi

for ((i=1; i<=$1; i++)); do
  echo ""
  echo "****************************************"
  echo "Iteration $i of $1"
  echo "****************************************"

  result=$(claude --dangerously-skip-permissions -p "@CLAUDE.md @PRD.md @progress.txt")

  echo "$result"

  if [[ "$result" == *"<promise>COMPLETE</promise>"* ]]; then
    echo ""
    echo "✅ PRD complete after $i iterations!"
    exit 0
  fi
done

echo ""
echo "⚠️ Reached $1 iterations. PRD may not be complete."