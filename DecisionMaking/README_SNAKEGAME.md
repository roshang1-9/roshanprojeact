# Snake Game - Web Version 🐍

This is a web-based implementation of the Snake game that runs directly in your browser. No server or Java runtime required!

## Features

✅ **Emoji Snake Head** - 🐍 dynamic snake with visual appeal
✅ **Boundary Detection** - Clear cyan border shows game boundaries
✅ **Self-Collision Detection** - Game ends when snake hits itself
✅ **Progressive Difficulty** - Speed increases as you eat more food
✅ **High Score Tracking** - Saves your best score in browser
✅ **Pause/Resume** - Press P to pause the game
✅ **Grid Background** - Visual grid makes positioning clear
✅ **Smooth Gameplay** - Responsive controls and animations

## How to Run

### Option 1: Direct File (Easiest)
1. Open `snakegame.html` directly in your web browser
   - Double-click the file, or
   - Right-click → "Open With" → Choose your browser

### Option 2: Local Web Server (Recommended)
Open a terminal in the folder containing `snakegame.html` and run:

**On macOS:**
```bash
python3 -m http.server 8000
```

**On Windows (PowerShell):**
```powershell
python -m http.server 8000
```

Then open `http://localhost:8000/snakegame.html` in your browser.

### Option 3: Deploy Online
Upload `snakegame.html` to any web hosting service:
- GitHub Pages (free)
- Netlify (free)
- Vercel (free)
- Any traditional web host

## Game Controls

| Key | Action |
|-----|--------|
| **↑ ↓ ← →** | Move snake |
| **P** | Pause/Resume |
| **SPACE** | Restart game |

## Game Rules

1. **Eat Hearts (❤)** → Grow longer and earn 10 points
2. **Don't Hit Walls** → Hitting the cyan boundary ends the game
3. **Don't Hit Yourself** → Snake can't occupy its own body
4. **Speed Increases** → Every 3 food eaten increases speed by 1 level
5. **High Score** → Beat your personal best!

## Game Over Conditions

The game ends when:
- **HIT WALL**: Snake head touches the boundary
- **HIT YOURSELF**: Snake head collides with its own body

## Technical Details

- **Language**: HTML5, CSS3, JavaScript (ES6+)
- **Canvas API**: For rendering the game
- **LocalStorage**: For persistent high score
- **Responsive Design**: Works on desktop and mobile
- **No Dependencies**: Pure vanilla JavaScript

## Browser Compatibility

Works on all modern browsers:
- ✅ Chrome/Chromium
- ✅ Firefox
- ✅ Safari
- ✅ Edge
- ✅ Opera

## Comparison with Java Version

| Feature | Java | Web |
|---------|------|-----|
| **Boundaries** | ✅ Implemented | ✅ Visible grid + cyan border |
| **Self-Collision** | ✅ Working | ✅ Working |
| **Emoji Head** | ✅ 🐍 | ✅ 🐍 |
| **Pause Feature** | ✅ P key | ✅ P key |
| **Speed Increase** | ✅ Yes | ✅ Yes |
| **High Score** | ✅ Session | ✅ Persistent |
| **Easy to Run** | ❌ Need Java | ✅ Just open in browser |

## Tips for Playing

1. **Master the Corners** - Use corner patterns to safely navigate
2. **Plan Ahead** - Look at where food spawns next
3. **Stay Centered** - Keep snake in middle when possible
4. **Use Pauses** - Take breaks with P key without closing the game
5. **Watch Speed** - Game gets harder quickly after you eat 6+ food

## Troubleshooting

**Game won't load?**
- Make sure you're opening `snakegame.html` (not the .java file)
- Try a different browser
- Clear browser cache (Ctrl+Shift+Delete or Cmd+Shift+Delete)

**High score not saving?**
- Check if LocalStorage is enabled in your browser
- Try opening game in private/incognito window (some browsers block LocalStorage there)

**Emoji not showing?**
- Update your browser to the latest version
- Try a different browser (Safari or Chrome usually work best)

## Enjoy the Game! 🎮

Have fun and try to beat the high score!
