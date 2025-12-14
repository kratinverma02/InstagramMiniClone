from flask import Blueprint, request, jsonify
from flask_jwt_extended import jwt_required, get_jwt_identity
from ..extensions import db
from ..models.post import Post

post_bp = Blueprint("post", __name__, url_prefix="/posts")

@post_bp.route("/", methods=["POST"])
@jwt_required()
def create_post():
    user_id = get_jwt_identity()
    data = request.json

    post = Post(
        image_url=data["image_url"],
        caption=data.get("caption", ""),
        user_id=user_id
    )
    db.session.add(post)
    db.session.commit()
    return jsonify(message="Post created"), 201
