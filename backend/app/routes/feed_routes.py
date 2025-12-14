from flask import Blueprint, jsonify
from flask_jwt_extended import jwt_required, get_jwt_identity
from ..models.post import Post
from ..models.user import User

feed_bp = Blueprint("feed", __name__, url_prefix="/feed")

@feed_bp.route("/", methods=["GET"])
@jwt_required()
def feed():
    user = User.query.get(get_jwt_identity())

    ids = [u.id for u in user.followed] + [user.id]

    posts = Post.query.filter(Post.user_id.in_(ids))\
        .order_by(Post.timestamp.desc()).all()

    return jsonify([
        {
            "id": p.id,
            "image_url": p.image_url,
            "caption": p.caption,
            "username": p.owner.username,
            "likes": len(p.likes),
            "comments": [
                {"user": c.user.username, "text": c.text}
                for c in p.comments
            ]
        } for p in posts
    ])

