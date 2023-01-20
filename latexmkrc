system("rm *.htm");

# EPUB generation with tex4ebook (default). Comment out if you want to use the alternative make4ht instead.
system("tex4ebook -e mybuild.mk4 -c htlatex/htlatex-tex4ebook -r 167 main ");

# Alternative: EPUB generation with make4ht. Uncomment all entries to use this approach. Comment out all system calls below if you use the tex4ebook approach above.
# system('make4ht -e mybuild.mk4 -uf xhtml -c htlatex/htlatex.cfg main "htm,mathjax,p-width,charset=utf-8" " -cunihtf -utf8"'); 
# system('cp -r images OEBPS');
# system('cp main.htm OEBPS/main.htm');
# system('cp *.svg OEBPS');
# system('zip -X -0 main.epub mimetype');
# system('zip -X -0 -ru main.epub META-INF');
# system('zip -X -0 -ru main.epub OEBPS');

# optional, zip all files into a single file for debugging
system('zip -r allfiles.zip .');