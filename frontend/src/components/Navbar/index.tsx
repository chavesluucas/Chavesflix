import { ReactComponent as GithubIcon } from 'assets/_img/github.svg'
import './styles.css'

export function Navbar() {

    return (

        <header>
            <nav className='container'>
                <div className='lcmovies-nav-content'>
                    <h1>LC Movies</h1>
                    <a href="https://github.com/chavesluucas" className='lcmovies-link'>
                        <div className='lcmovies-contact-container'>
                            <GithubIcon />
                            <p className='lcmovies-contact-link'>
                                /chaaveslucas
                            </p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>

    );

}