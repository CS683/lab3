## Lab3 Report

Shanghua Yang

Github link: <https://github.com/CS683/lab3/tree/main>

In this lab, I worked based on code example
ProjectPortalRecyclerMVVMNavigation. Similar to Lab2, I add several
attributes including authors, link, keywords and isFavorite to
DetailFragment and EditFragment and corresponding layouts. In
EditFragment, I use checkbox to toggle favorite option for every project
and favorited project will have a filled star by the project title.

For adding project feature, I created a new fragment AddProjectFragment
which intends to add new project to project list. Also, I add an add
icon in detailFragment that has an onclicklistener which will navigate
to AddProjectFragment. After submit button is hit, it will navigate back
to detailFragment.

The problem I encounter is that project list fragment and detail
fragment are in slide pane, if I put add icon in project list fragment,
the navigation will start from detail fragment to add project fragment,
and it will not be seen by user because the screen will remain at
project list fragment. Therefore, my alternative solution is put add
button under detail fragment. Also, the added project will not appear at
once, it needs refresh to show in the project list.
