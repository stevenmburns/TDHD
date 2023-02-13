import pygments.styles.xcode
from pygments_ansi_color import color_tokens

# Note: You can use different background colors for improved readability.
fg_colors = bg_colors = {
    'Black': '#000000',
    'Red': '#EF2929',
    'Green': '#8AE234',
    'Yellow': '#FCE94F',
    'Blue': '#3465A4',
    'Magenta': '#c509c5',
    'Cyan': '#34E2E2',
    'White': '#ffffff',
}
class AnsiStyle(pygments.styles.xcode.XcodeStyle):
    styles = dict(pygments.styles.xcode.XcodeStyle.styles)
    styles.update(color_tokens(fg_colors, bg_colors))
