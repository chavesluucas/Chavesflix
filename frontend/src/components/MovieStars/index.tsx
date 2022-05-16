import { ReactComponent as StarFull} from 'assets/_img/star-full.svg'
import { ReactComponent as StarHalf} from 'assets/_img/star-half.svg'
import { ReactComponent as StarEmpty} from 'assets/_img/star-empty.svg'
import './styles.css'

export default function MovieStars() {

    return (

        <div className="dsmovie-stars-container">
            <StarFull />
            <StarFull />
            <StarFull />
            <StarHalf />
            <StarEmpty />
        </div>

    );

}